export class ArtistDTO {
    href!: string;
    id!: string;
    name!: string;
    type!: string;
  
    constructor(data: Partial<ArtistDTO>) {
      Object.assign(this, data);
    }
  }
  