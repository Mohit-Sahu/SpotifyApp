import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DownloadComponent } from './components/download/download.component';
import { HomeComponent } from './components/home/home.component';
import { HomesectionComponent } from './components/home/homesection/homesection.component';
import { PlaysongComponent } from './components/home/playsong/playsong.component';
import { ViewallComponent } from './components/home/viewall/viewall.component';
import { IndexComponent } from './components/index/index.component';
import { SigninComponent } from './components/signin/signin.component';
import { SignupComponent } from './components/signup/signup.component';
import { LikedSongsComponent } from './components/liked-songs/liked-songs.component';
import { ForbiddenComponent } from './components/forbidden/forbidden.component';
import { ErrorComponent } from './components/error/error.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'index',
    pathMatch: 'full',
  },
  {
    path: 'index',
    component: IndexComponent,
  },
  {
    path: 'login',
    component: SigninComponent,
  },
  {
    path: 'signup',
    component: SignupComponent,
  },
  {
    path: 'home',
    component: HomeComponent,
  },

  {
    path: 'download',
    component: DownloadComponent,
  },
  {
    path: 'forbidden',
    component: ForbiddenComponent,
  },
  {
    path: 'error',
    component: ErrorComponent,
  },
  {
    path: 'home',
    component: HomeComponent,
    children: [
      {
        path: 'songs',
        component: HomesectionComponent,
      },
      {
        path: 'view',
        component: ViewallComponent,
      },
      {
        path: 'play',
        component: PlaysongComponent,
      },
      {
        path: 'liked',
        component: LikedSongsComponent,
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
