import { Component, HostListener, OnInit } from '@angular/core';
import { AlbumDTO } from 'src/app/_model/album-dto';
import { TrackDTO } from 'src/app/_model/track-dto';
import { MusicListService } from 'src/app/_services/music-list.service';
import { WishlistService } from 'src/app/_services/wishlist.service';
import Swal from 'sweetalert2';
import { ActivatedRoute, ActivatedRouteSnapshot } from '@angular/router';


@Component({
  selector: 'app-playsong',
  templateUrl: './playsong.component.html',
  styleUrls: ['./playsong.component.scss']
})
export class PlaysongComponent implements OnInit {
  albumId!: string;
  isHovered = false;
  album!: AlbumDTO;

  constructor(private listService: MusicListService,private wishlistService: WishlistService,
    private route: ActivatedRoute) {}


  ngOnInit(): void {
     this.route.params['subscribe']((params: { [x: string]: string; }) => {
      this.albumId = params['albumId'];
      // Use this.albumId as needed
    }); // Replace with the actual album ID
  this.getSongsList(this.albumId);
   
  }

  
  addToWishlist(track: any) {
    console.log(track);
    this.wishlistService.addToWishlist(track);
    Swal.fire("Song added to wishlist");
  }

  getSongsList(albumId:string){
    this.listService.getAlbumById(albumId).subscribe(
      (data: AlbumDTO) => {
        this.album = data;
        console.log('Album Data:', this.album);
      },
      (error: any) => {
        console.error('Error fetching album data:', error);
      }
    );
  }


  playSong(imageUrl:String,track:any){
    console.log(imageUrl);
  }

  showOptions(song: any) {
    // Handle the click event for the options button
    console.log('Options clicked for song:', song);
    // Add your logic to display options or perform other actions
  }

  isSmallScreen: boolean = false;

  // Other properties and methods as needed

  @HostListener('window:resize', ['$event'])
  onResize(event: any) {
    this.isSmallScreen = window.innerWidth <= 768; // Adjust the breakpoint as needed
  }
  

  toggleHover(hover: boolean): void {
    this.isHovered = hover;
  }

}

// Import necessary modules
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'msToMinutes',
})
export class MsToMinutesPipe implements PipeTransform {
  transform(value: number): string {
    const minutes: number = Math.floor(value / 60000);
    const seconds: number = Math.floor((value % 60000) / 1000);
    return `${minutes}:${seconds < 10 ? '0' : ''}${seconds}`;
  }


 
}
