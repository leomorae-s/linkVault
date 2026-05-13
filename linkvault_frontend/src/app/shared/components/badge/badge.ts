import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-badge',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './badge.html',
})
export class Badge {
  @Input() variant: 'default' | 'orange' | 'black' | 'outline' = 'default';

  get classes(): string {
    const base = 'font-mono text-[10px] font-bold uppercase tracking-widest px-2 py-0.5 border-2 border-black inline-block';
    const variants: Record<string, string> = {
      default: 'bg-[#f0ebe0] text-black',
      orange:  'bg-[#f5a623] text-black',
      black:   'bg-black text-[#f5a623]',
      outline: 'bg-transparent text-black',
    };
    return `${base} ${variants[this.variant]}`;
  }
}