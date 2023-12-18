import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-liked-songs',
  templateUrl: './liked-songs.component.html',
  styleUrls: ['./liked-songs.component.scss']
})
export class LikedSongsComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  songs = [
    { title: 'Song 1', artist: 'Album 1', duration: '3:45' },
    { title: 'Song 2', artist: 'Album 2', duration: '4:20' },
    { title: 'Song 3', artist: 'Album 3', duration: '5:10' },
    // Add more songs as needed
  ];

}
