import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { InputComponent } from '../../shared/components/input/input';
import { Button } from '../../shared/components/button/button';
import { LinkService } from '../../services/linkService';

@Component({
  selector: 'app-link-form',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RouterModule,
    InputComponent,
    Button,
  ],
  templateUrl: './link-form.html',
})
export class LinkForm implements OnInit {
  form: FormGroup;
  editId: number | null = null;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    private service: LinkService
  ) {
    this.form = this.fb.group({
      link: ['', [Validators.required, Validators.pattern('https?://.+')]],
      description: [''],
    });
  }

  ngOnInit(): void {
    this.editId = Number(this.route.snapshot.paramMap.get('id')) || null;
  }

  getControl(name: string): FormControl {
    return this.form.get(name) as FormControl;
  }

  submit(): void {
    if (this.form.invalid) return;
    const payload = this.form.value;

    if (this.editId) {
      this.service.update(this.editId, payload).subscribe(() => this.router.navigate(['/']));
    } else {
      this.service.save(payload).subscribe(() => this.router.navigate(['/']));
    }
  }

  cancel(): void {
    this.router.navigate(['/']);
  }
}