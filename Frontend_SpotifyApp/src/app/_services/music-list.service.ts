import { Injectable } from '@angular/core';
import { AlbumDTO } from '../_model/album-dto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

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
}
