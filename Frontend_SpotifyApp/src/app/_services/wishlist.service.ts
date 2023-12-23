import { Injectable } from '@angular/core';
import { Wishlistitem } from '../_model/wishlistitem'; 
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { ArtistDTO } from './../_model/artist-dto';

@Injectable({
  providedIn: 'root'
})
export class WishlistService {
  [x: string]: any;
  private wishlist: any[] = [];
  private wishlistitem!: Wishlistitem;
  private baseUrl = 'http://localhost:8084/api/v1.0/wishlist';

  constructor(private http: HttpClient) {}

  addToWishlist(track: any) :Observable<any> {
    // Check if the track is not already in the wishlist
    if (!this.isInWishlist(track)) {
      this.wishlist.push(track);
      this.wishlistitem = {
        userId: "mohit",
        trackId: track.id,
        name:track.name,
        href:track.href,
        duration_ms:track.duration_ms,
        artists:track.artists[0].name
      };
  
      // Send a request to the backend to add to the wishlist
      const url = `${this.baseUrl}/add`;
  
      this.http.post(url, this.wishlistitem, { responseType: 'text' }).subscribe(
        (response: any) => {
          console.log('HTTP POST successful. Response:', response);
          // Handle success if needed
        },
        (error: any) => {
          console.error('HTTP POST error:', error);
          // Handle error if needed
        }
      );
    }
    return new Observable();
  }
  

  removeFromWishlist(track: any): Observable<any> {
    // Log the track object to check if it has the required properties
    console.log('Removing from wishlist:', track);
  
    // Filter locally
    this.wishlist = this.wishlist.filter((t) => t.id !== track.id);
  
    // Log the filtered wishlist to check if the item is removed locally
    console.log('Wishlist after local removal:', this.wishlist);
  
    // Send a request to the backend to remove from the wishlist
    const url = `${this.baseUrl}/remove/${track.userId}/${track.trackId}`;
    console.log('Remove URL:', url);
  
    return this.http.delete(url, { responseType: 'text' });
  }
  
  getWishlist(userId: string): Observable<any[]> {
    // Send a request to the backend to get the wishlist for a specific user
    const url = `${this.baseUrl}/list/${userId}`;
    return this.http.get<any[]>(url);
  }


  isInWishlist(track: any): boolean {
    return this.wishlist.some((t) => t.id === track.id);
  }

  
}
