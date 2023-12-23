import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DownloadComponent } from './components/download/download.component';
import { HomeComponent } from './components/home/home.component';
import { HomesectionComponent } from './components/home/homesection/homesection.component';
import { PlaysongComponent } from './components/home/playsong/playsong.component';
import { IndexComponent } from './components/index/index.component';
import { SigninComponent } from './components/signin/signin.component';
import { SignupComponent } from './components/signup/signup.component';
import { LikedSongsComponent } from './components/liked-songs/liked-songs.component';
import { ForbiddenComponent } from './components/forbidden/forbidden.component';
import { ErrorComponent } from './components/error/error.component';
import { AuthGuard } from './security/auth.guard';  // Update this import with the correct path

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
    data: { roles: ['ROLE_CUSTOMER'] } ,
    canActivate: [AuthGuard],  // Secure the entire /home route
    children: [
      {
        path: 'songs',
        component: HomesectionComponent,
      },
      { path: 'play/:albumId', component: PlaysongComponent },
      {
        path: 'liked',
        component: LikedSongsComponent,
      },
    ],
  },
  {
    path: 'download',
    component: DownloadComponent,
    canActivate: [AuthGuard],  // Secure the /download route
  },
  {
    path: 'forbidden',
    component: ForbiddenComponent,
  },
  {
    path: 'error',
    component: ErrorComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
