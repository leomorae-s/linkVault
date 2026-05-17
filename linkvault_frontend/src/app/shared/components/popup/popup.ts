import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';

export interface PopupConfig {
  title: string;
  subtitle?: string;
  description?: string;
  confirmLabel?: string;
  cancelLabel?: string | null;
  hint?: string;
  danger?: boolean;
}

@Component({
  selector: 'app-popup',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './popup.html',
})
export class Popup {
  @Input() isOpen = false;
  @Input() config: PopupConfig = { title: 'TEM CERTEZA?' };

  @Output() confirmed = new EventEmitter<void>();
  @Output() cancelled = new EventEmitter<void>();

  get confirmClass(): string {
    const base = `font-mono font-bold uppercase tracking-wider text-[13px] px-5 py-2.5 w-full
                  border-2 border-black shadow-[4px_4px_0_#000] hover:shadow-[2px_2px_0_#000]
                  active:translate-x-[3px] active:translate-y-[3px] active:shadow-none transition-all`;

    return this.config.danger
      ? `${base} bg-black text-[#f5a623]`
      : `${base} bg-[#f5a623] text-black`;
  }

  confirm() { this.confirmed.emit(); }
  cancel() { this.cancelled.emit(); }
}