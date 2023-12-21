import { Component, OnInit } from '@angular/core';
import { AlbumDTO } from 'src/app/_model/album-dto';
import { MusicListService } from 'src/app/_services/music-list.service';

@Component({
  selector: 'app-homesection',
  templateUrl: './homesection.component.html',
  styleUrls: ['./homesection.component.scss']
})
export class HomesectionComponent implements OnInit {
  songs: any[]= [];;
  cards: any[] = [];

  album!: AlbumDTO;

  constructor(private listService: MusicListService) {}



  ngOnInit(): void {
    this.array()
    const albumId = '4aawyAB9vmqN3uQ7FjRGTy'; // Replace with the actual album ID

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

  

 

  
array(){
  this.songs=[
    { 
      heading:'Shows to try',
      subheader: `Podcasts we think you'ii get hooked on.`
     },
    {
      heading:'Stress free ambient'   
    },
  ]
  this.cards=[
    {
      img: 'assets/img/song1.png',
      songtitle: 'First Day Back',
      bandname: 'Stitcher and Tally Abecassis'
    },
    {
      img: 'assets/img/song2.png',
      songtitle: 'Resistance',
      bandname: 'Gimlet'
    },
    {
      img: 'assets/img/song3.png',
      songtitle: 'In the Dark',
      bandname: 'APM Reports'
    },
    {
      img: 'assets/img/song4.png',
      songtitle: 'Natal',
      bandname: 'The Woodshadow, You Had Me at Blacl'
    },
    {
      img: 'assets/img/song3.png',
      songtitle: 'In the Dark',
      bandname: 'APM Reports'
    },
   
  ] 
}
  
}
