import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormControl, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-input',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './input.html',
})
export class InputComponent {
  @Input() label = '';
  @Input() placeholder = '';
  @Input() type: 'text' | 'email' | 'password' | 'url' = 'text';
  @Input() multiline = false;
  @Input() control: FormControl = new FormControl('');

  focused = false;

  get inputClasses(): string {
    return `w-full font-mono text-[13px] px-3 py-2.5 border-2 border-black outline-none transition-shadow
      ${this.focused ? 'bg-[#f5a623] shadow-[4px_4px_0_#000]' : 'bg-white'}`;
  }
}