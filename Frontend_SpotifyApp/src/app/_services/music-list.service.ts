import { Injectable } from '@angular/core';
import { AlbumDTO } from '../_model/album-dto';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MusicListService {

  private baseUrl = 'http://localhost:8083/api/v1.0/track';

  constructor(private http: HttpClient) {}

  getAlbumById(albumId: string): Observable<AlbumDTO> {
    const url = `${this.baseUrl}/albums/${albumId}`;
    return this.http.get<AlbumDTO>(url);
  }

  searchAlbums(query: string): Observable<AlbumDTO[]> {
    const url = `${this.baseUrl}/search?query=${query}&type=album`;

    return this.http.get<any>(url).pipe(
      map((response) => response),  // Adjust this based on your API response structure
      catchError((error) => {
        console.error('Error searching albums:', error);
        throw error;
      })
    );
  }
}
