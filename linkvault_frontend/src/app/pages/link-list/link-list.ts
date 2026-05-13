import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';
import { LinkService, Link } from '../../services/linkService';

@Component({
  selector: 'app-link-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './link-list.html',
})
export class LinkList implements OnInit {
  links: Link[] = [];

  constructor(
    private router: Router, 
    private service: LinkService,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.loadLinks();
  }

  loadLinks(): void {
    this.service.getAll().subscribe({
      next: (page) => {
        if (page && page.content) {
          this.links = page.content;
          this.cdr.detectChanges(); 
        }
      },
      error: (err) => console.error('Erro ao carregar links:', err)
    });
  }

  open(url: string): void {
    window.open(url, '_blank', 'noopener');
  }

  delete(id: number): void {
    this.service.delete(id).subscribe(() => {
      this.links = this.links.filter(l => l.id !== id);
      this.cdr.detectChanges();
    });
  }
}