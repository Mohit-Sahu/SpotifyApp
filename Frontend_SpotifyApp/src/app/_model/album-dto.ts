import { ArtistDTO } from './artist-dto'; 
import { TrackDTO } from './track-dto'; 

export class AlbumDTO {
  album_type!: string;
  total_tracks!: number;
  id!: string;
  name!: string;
  artists: ArtistDTO[];
  tracks!: {
        href: string;
        total: number;
        items: TrackDTO[];
    };

  constructor(data: Partial<AlbumDTO>) {
    Object.assign(this, data);
    this.artists = (data.artists || []).map(artist => new ArtistDTO(artist));
    this.tracks.items = (data.tracks?.items || []).map(track => new TrackDTO(track));
  }
}
