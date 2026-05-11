import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { LinkService } from '../../services/linkService';
import { NzFormModule } from 'ng-zorro-antd/form';
import { NzInputModule } from 'ng-zorro-antd/input';
import { NzButtonModule } from 'ng-zorro-antd/button';

@Component({
  selector: 'app-link-form',
  imports: [ReactiveFormsModule, NzFormModule, NzInputModule, NzButtonModule],
  templateUrl: './link-form.html',
  styleUrl: './link-form.css',
})
export class LinkForm implements OnInit {

  form!: FormGroup;
  editingId: number | null = null;

  constructor(
    private fb: FormBuilder,
    private service: LinkService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.form = this.fb.group({
      link: ['', [Validators.required]],
      description: ['']
    });


    this.editingId = Number(this.route.snapshot.paramMap.get('id')) || null;
  }

  submit() {
    if (this.form.invalid) return;

    const dto = this.form.value;

    if (this.editingId) {
      this.service.update(this.editingId, dto).subscribe(() => {
        this.router.navigate(['/']);
      });
    } else {
      this.service.save(dto).subscribe(() => {
        this.router.navigate(['/']);
      });
    }
  }

  cancel() {
    this.router.navigate(['/']);
  }
}
