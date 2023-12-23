import { ArtistDTO } from "./artist-dto";

export interface Wishlistitem {
   
        favoriteId?: string;
        userId: string;
        trackId: string;
        dateAdded?: Date;
         name:string;
    
         href:string;
        
         duration_ms:number;
         artists?: ArtistDTO[];
}
