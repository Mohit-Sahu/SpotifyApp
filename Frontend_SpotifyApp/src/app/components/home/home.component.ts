import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { AlbumDTO } from 'src/app/_model/album-dto';
import { MusicListService } from 'src/app/_services/music-list.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  albums: AlbumDTO[]=[];
  searchQuery: string = '';

  constructor(private listService: MusicListService,private router:Router) { }

  ngOnInit(): void {
   
  }

  navigateToPlaysong(albumId: string) {
    this.router.navigate(['home/play', albumId]);
  }

   searchAlbums(query: string, type: string) {
    this.listService.searchAlbums(query).subscribe(
      (searchResults: AlbumDTO[]) => {
        // Handle the search results
        console.log('Search Results:', searchResults);
        this.albums = searchResults;
      },
      (error: any) => {
        console.error('Error searching albums:', error);
      }
    );
  }



  search() {
    if (this.searchQuery.trim() !== '') {
      // Navigate to another page with the search query as a parameter
      this.router.navigate(['home/songs'], {
        queryParams: { query: this.searchQuery, type: 'album' }
      });
    }
  }


  
  }


