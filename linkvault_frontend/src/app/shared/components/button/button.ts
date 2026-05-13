import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';

type ButtonVariant = 'primary' | 'secondary' | 'danger' | 'ghost';
type ButtonSize = 'sm' | 'md';

@Component({
  selector: 'app-button',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './button.html',
})
export class Button {
  @Input() variant: ButtonVariant = 'primary';
  @Input() size: ButtonSize = 'md';
  @Input() disabled = false;
  @Input() type: 'button' | 'submit' | 'reset' = 'button';
  @Output() clicked = new EventEmitter<MouseEvent>();

  get classes(): string {
    const base = `font-mono font-bold uppercase tracking-wider border-2 border-black
      inline-flex items-center justify-center gap-2 cursor-pointer transition-all
      active:translate-x-[3px] active:translate-y-[3px] active:shadow-none
      disabled:opacity-50 disabled:cursor-not-allowed w-full`;

    const sizes: Record<ButtonSize, string> = {
      sm: 'text-[11px] px-3 py-1.5',
      md: 'text-[13px] px-5 py-2.5',
    };

    const variants: Record<ButtonVariant, string> = {
      primary:   'bg-[#f5a623] text-black shadow-[4px_4px_0_#000] hover:shadow-[2px_2px_0_#000]',
      secondary: 'bg-[#f0ebe0] text-black shadow-[4px_4px_0_#000] hover:shadow-[2px_2px_0_#000]',
      danger:    'bg-black text-[#f5a623] shadow-[4px_4px_0_#f5a623] hover:shadow-[2px_2px_0_#f5a623]',
      ghost:     'bg-transparent text-black hover:bg-black hover:text-[#f5a623]',
    };

    return `${base} ${sizes[this.size]} ${variants[this.variant]}`;
  }
}