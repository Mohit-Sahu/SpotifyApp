import { Component, OnInit } from '@angular/core';
import { AlbumDTO } from 'src/app/_model/album-dto';
import { TrackDTO } from 'src/app/_model/track-dto';
import { MusicListService } from 'src/app/_services/music-list.service';
import { WishlistService } from 'src/app/_services/wishlist.service';

@Component({
  selector: 'app-playsong',
  templateUrl: './playsong.component.html',
  styleUrls: ['./playsong.component.scss']
})
export class PlaysongComponent implements OnInit {

  songs = [
    { title: 'Song 1', artist: 'Album 1', duration: '3:45' },
    { title: 'Song 2', artist: 'Album 2', duration: '4:20' },
    { title: 'Song 3', artist: 'Album 3', duration: '5:10' },
    // Add more songs as needed
  ];
  album!: AlbumDTO;

  constructor(private listService: MusicListService,private wishlistService: WishlistService) {}


  ngOnInit(): void {
    const albumId = '6LWZ330atfYF43nk7m3pKW'; // Replace with the actual album ID

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

  
  addToWishlist(track: TrackDTO) {
    console.log(track);
    this.wishlistService.addToWishlist(track);
  }

}
