import { ArtistDTO } from "./artist-dto"; 

export class TrackDTO {
  artists: ArtistDTO[];
  duration_ms!: number;
  href!: string;
  id!: string;
  name!: string;
  track_number!: number;
  type!: string;

  constructor(data: Partial<TrackDTO>) {
    Object.assign(this, data);
    this.artists = (data.artists || []).map(artist => new ArtistDTO(artist));
  }
}
