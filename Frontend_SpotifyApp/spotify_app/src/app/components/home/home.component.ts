import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SearchbarService } from 'src/app/services/searchbar.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  content: any [] = [];

  constructor() { }

  ngOnInit(): void {
    this.array()
  }
array(){
  this.content=[
      {
        img:'assets/img/i1.png',
       title: 'Play your favorites.',
       des: 'Listen to the songs you love, and discover new music and podcasts.'
      },
      {
        img:'assets/img/i2.png',
        title: 'Playlists made easy.',
        des: `We'll help you make playlists. Or enjoy playlists made by music experts.`
      },
      {
        img:'assets/img/i3.png',
        title: 'Make it yours.',
        des: `Tell us what you like, and we'll recommend music for you.`
      },
      {
        img:'assets/img/i4.png',
        title: 'Save mobile data.',
        des: `To use less data when you play music, turn on Data Saver in Settings.`
      }
  ]
}
}
