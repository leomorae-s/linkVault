import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-card',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './card.html',
})
export class Card {
  @Input() title = '';
  @Input() link = '';
  @Input() description = '';
  @Input() createdAt = '';
}