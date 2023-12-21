import { Component, OnInit } from '@angular/core';
import { WishlistService } from 'src/app/_services/wishlist.service';

@Component({
  selector: 'app-liked-songs',
  templateUrl: './liked-songs.component.html',
  styleUrls: ['./liked-songs.component.scss']
})
export class LikedSongsComponent implements OnInit {

  songs = [
    { title: 'Song 1', artist: 'Album 1', duration: '3:45' },
    { title: 'Song 2', artist: 'Album 2', duration: '4:20' },
    { title: 'Song 3', artist: 'Album 3', duration: '5:10' },
    // Add more songs as needed
  ];

  wishlist!: any[];

  constructor(private wishlistService: WishlistService) {
    // Subscribe to the wishlist observable
    this.wishlistService.getWishlist('mohit').subscribe(wishlist => {
      this.wishlist = wishlist;
      console.log(this.wishlist);
    });
  }

  ngOnInit(): void {
  }

  removeFromWishlist(track: any) {
    this.wishlistService.removeFromWishlist(track).subscribe(() => {
      // Update the local wishlist after successful removal
      this.updateWishlist();
    });
  }
  
  private updateWishlist() {
    // Fetch the latest wishlist from the service
    this.wishlistService.getWishlist('mohit').subscribe(wishlist => {
      this.wishlist = wishlist;
    });
  }
}
