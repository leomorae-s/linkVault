import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LinkForm } from './link-form';

describe('LinkForm', () => {
  let component: LinkForm;
  let fixture: ComponentFixture<LinkForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LinkForm],
    }).compileComponents();

    fixture = TestBed.createComponent(LinkForm);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
