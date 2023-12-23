import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-audioplayer',
  templateUrl: './audioplayer.component.html',
  styleUrls: ['./audioplayer.component.scss']
})
export class AudioplayerComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    this.audioPlayer.nativeElement.addEventListener('ended', () => {
      this.playNext();
    });
  }

  songs = [
    { title: 'Song 1', artist: 'Artist 1', audioSrc: 'assets/audio/arjan.mp3' },
    { title: 'Song 2', artist: 'Artist 2', audioSrc: 'assets/audio/ram.mp3' },
    { title: 'Song 2', artist: 'Artist 2', audioSrc: 'assets/audio/ring.mp3' },
    { title: 'Song 2', artist: 'Artist 2', audioSrc: 'assets/audio/entry.mp3' },
    { title: 'Song 2', artist: 'Artist 2', audioSrc: 'assets/audio/sariduniya.mp3' },
    // Add more songs as needed
  ];

  @ViewChild('audioPlayer')
  audioPlayer!: ElementRef;

  currentSongIndex = 0;
  currentSong = this.songs[this.currentSongIndex];

 

  playPrevious() {
    this.currentSongIndex = (this.currentSongIndex - 1 + this.songs.length) % this.songs.length;
    this.currentSong = this.songs[this.currentSongIndex];
    this.audioPlayer.nativeElement.load();
    this.audioPlayer.nativeElement.play();
  }

  playNext() {
    this.currentSongIndex = (this.currentSongIndex + 1) % this.songs.length;
    this.currentSong = this.songs[this.currentSongIndex];
    this.audioPlayer.nativeElement.load();
    this.audioPlayer.nativeElement.play();
  }

}
