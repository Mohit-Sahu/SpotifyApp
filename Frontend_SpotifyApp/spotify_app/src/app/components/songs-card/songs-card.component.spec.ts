import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SongsCardComponent } from './songs-card.component';

describe('SongsCardComponent', () => {
  let component: SongsCardComponent;
  let fixture: ComponentFixture<SongsCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SongsCardComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SongsCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
