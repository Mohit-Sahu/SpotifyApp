import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { IndexComponent } from './components/index/index.component';
import { SigninComponent } from './components/signin/signin.component';
import { SignupComponent } from './components/signup/signup.component';
import { HomeComponent } from './components/home/home.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { Section1Component } from './components/index/section1/section1.component';
import { Section2Component } from './components/index/section2/section2.component';
import { Section3Component } from './components/index/section3/section3.component';
import { Section4Component } from './components/index/section4/section4.component';
import { Section5Component } from './components/index/section5/section5.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DownloadComponent } from './components/download/download.component';
import { HomesectionComponent } from './components/home/homesection/homesection.component';
import { PlaysongComponent } from './components/home/playsong/playsong.component';
import { MaterialModule } from './material/material.module';
import { LikedSongsComponent } from './components/liked-songs/liked-songs.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ForbiddenComponent } from './components/forbidden/forbidden.component';
import { ErrorComponent } from './components/error/error.component';
import { RouterModule } from '@angular/router';
import { AudioplayerComponent } from './components/home/audioplayer/audioplayer.component';
import { SidebarComponent } from './components/home/sidebar/sidebar.component';
import { MsToMinutesPipe } from './components/home/playsong/playsong.component'; 


@NgModule({
  declarations: [
    AppComponent,
    IndexComponent,
    SigninComponent,
    SignupComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    Section1Component,
    Section2Component,
    Section3Component,
    Section4Component,
    Section5Component,
    DownloadComponent,
    HomesectionComponent,
    PlaysongComponent,
    LikedSongsComponent,
    ForbiddenComponent,
    ErrorComponent,
    AudioplayerComponent,
    SidebarComponent,
    MsToMinutesPipe
  ],
  imports: [
  BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule,
    

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
