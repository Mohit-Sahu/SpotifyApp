import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { WishlistService } from 'src/app/_services/wishlist.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-liked-songs',
  templateUrl: './liked-songs.component.html',
  styleUrls: ['./liked-songs.component.scss']
})
export class LikedSongsComponent implements OnInit {

  wishlist!: any[];
  username!:any[];

  constructor(private wishlistService: WishlistService,private changeDetectorRef: ChangeDetectorRef) {
  const userId = "mohit"; // Replace with the actual userId
  this.wishlistService.getWishlist(userId).subscribe(
    (wishlist: any[]) => {
      this.wishlist = wishlist;
      console.log('Wishlist retrieved:', wishlist);
      this.username=wishlist;
    },
    (error) => {
      console.error('Error retrieving wishlist:', error);
    }
  );
  }

  ngOnInit(): void {
  }




  removeFromWishlist(track: any) {
    this.wishlistService.removeFromWishlist(track).subscribe(
      (response) => {
        // Log the success response
        console.log('Remove from wishlist successful:', response);
        // Update the local wishlist after successful removal
        this.changeDetectorRef.detectChanges();
        Swal.fire("Removed from wishlist");
      },
      (error) => {
        // Log the error response
        console.error('Error during removal from wishlist:', error);
      }
    );
  }

  convertToMinutes(ms: number): string {
    const minutes = Math.floor(ms / 60000);
    const seconds = ((ms % 60000) / 1000).toFixed(0);
    return `${minutes}:${(+seconds < 10 ? '0' : '')}${seconds}`;
  }

}
