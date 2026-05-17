import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';
import { LinkService, Link } from '../../services/linkService';
import { Popup, PopupConfig } from '../../shared/components/popup/popup';

@Component({
  selector: 'app-link-list',
  standalone: true,
  imports: [CommonModule, RouterModule, Popup],
  templateUrl: './link-list.html',
})
export class LinkList implements OnInit {
  links: Link[] = [];

  showDeleteDialog = false;
  linkToDelete: number | null = null;

  deleteConfig: PopupConfig = {
    title: 'DELETAR\nESTE LINK.',
    subtitle: 'Ação Irreversível',
    description: 'Esta ação não pode ser desfeita.',
    confirmLabel: 'SIM, DELETAR',
    danger: true,
  };

  constructor(
    private router: Router,
    private service: LinkService,
    private cdr: ChangeDetectorRef
  ) { }

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
      error: (err) => console.error('Erro ao carregar links:', err),
    });
  }

  open(url: string): void {
    window.open(url, '_blank', 'noopener');
  }

  openDeleteDialog(id: number): void {
    this.linkToDelete = id;
    this.showDeleteDialog = true;
  }

  onDeleteConfirmed(): void {
    if (this.linkToDelete === null) return;
    this.service.delete(this.linkToDelete).subscribe(() => {
      this.links = this.links.filter((l) => l.id !== this.linkToDelete);
      this.linkToDelete = null;
      this.showDeleteDialog = false;
      this.cdr.detectChanges();
    });
  }

  onDeleteCancelled(): void {
    this.linkToDelete = null;
    this.showDeleteDialog = false;
  }
}