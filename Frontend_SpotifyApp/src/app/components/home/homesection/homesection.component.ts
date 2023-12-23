import { Component, OnInit } from '@angular/core';
import { AlbumDTO } from 'src/app/_model/album-dto';
import { MusicListService } from 'src/app/_services/music-list.service';
import { ActivatedRoute, Router } from '@angular/router';
import { forkJoin } from 'rxjs/internal/observable/forkJoin';

@Component({
  selector: 'app-homesection',
  templateUrl: './homesection.component.html',
  styleUrls: ['./homesection.component.scss']
})
export class HomesectionComponent implements OnInit {
  songs: any[] = [];
  cards: any[] = [];
  albums: AlbumDTO[] = []; // Store the fetched albums
  searchQuery: string = '';
  
  constructor(private listService: MusicListService, private router: Router,private route: ActivatedRoute) {}

  array() {
    return ['4aawyAB9vmqN3uQ7FjRGTy', '0a183xiCHiC1GQd8ou7WXO','7qRoSVSyHeA9qtOXUpBwRI','1PiWJYmGI9HpaVuaWYk9th'];
  }

  ngOnInit(): void {
    const albumIds = this.array();
    this.route.queryParams.subscribe(params => {
      this.searchQuery = params['query'];
      this.searchAlbums(this.searchQuery,"album");
      // Now you can use this.searchQuery as needed in this component
    });

    // Use forkJoin to fetch data for multiple albums
    const requests = albumIds.map((albumId) =>
      this.listService.getAlbumById(albumId)
    );

    forkJoin(requests).subscribe(
      (albumResponses: AlbumDTO[]) => {
        // Store the fetched albums
        this.albums = albumResponses;
        console.log('Albums Data:', this.albums);
      },
      (error: any) => {
        console.error('Error fetching album data:', error);
      }
    );
  }

  navigateToPlaysong(albumId: string) {
    this.router.navigate(['home/play', albumId]);
  }

  searchAlbums(query: string, type: string) {
    this.listService.searchAlbums(query).subscribe(
      (searchResults: any) => {
        // Check if searchResults.albums.items is not empty or undefined
        if (searchResults && searchResults.albums && searchResults.albums.items && searchResults.albums.items.length > 0) {
          // Extract the items array and assign it to this.albums
          this.albums = searchResults.albums.items;
          console.log('Search Results:', this.albums);
        } else {
          // Handle the case when no data is available
          console.log('No data available for the search query:', query);
          // You might want to show a message to the user
        }
      },
      (error: any) => {
        console.error('Error searching albums:', error);
      }
    );
  }
}
