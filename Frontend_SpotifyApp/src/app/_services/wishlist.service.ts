import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class WishlistService {
  private baseUrl = 'http://localhost:8084/api/v1.0/wishlist';
  wishlist: any;

  constructor(private http: HttpClient) {}

  addToWishlist(track: any): Observable<any> {
    // Check if the track is not already in the wishlist locally
    if (!this.isInWishlist(track)) {
      // Push to the local wishlist
      this.wishlist.push(track);

      // Send a request to the backend to add to the wishlist
      const url = `${this.baseUrl}/add`;
      return this.http.post(url, track);
    }

    // If the track is already in the wishlist, return an Observable of undefined
    return new Observable();
  }

  removeFromWishlist(track: any): Observable<any> {
    // Filter locally
    this.wishlist = this.wishlist.filter((t: { id: any; }) => t.id !== track.id);

    // Send a request to the backend to remove from the wishlist
    const url = `${this.baseUrl}/remove/${track.id}`;
    return this.http.delete(url);
  }

  getWishlist(userId: string): Observable<any[]> {
    // You may want to send a request to the backend to get the wishlist
    const url = `${this.baseUrl}/list/${userId}`;
    return this.http.get<any[]>(url);
  }

  isInWishlist(track: any): Observable<boolean> {
    // Send a request to the backend to check if it's in the wishlist
    const url = `${this.baseUrl}/check/${track.id}`;
    return this.http.get<boolean>(url);
  }
}
