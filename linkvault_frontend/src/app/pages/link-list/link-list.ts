import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RouterModule } from '@angular/router';
import { LinkService, Link } from '../../services/linkService';
import { NzTableModule } from 'ng-zorro-antd/table';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzPopconfirmModule } from 'ng-zorro-antd/popconfirm';

@Component({
  selector: 'app-link-list',
  standalone: true,
  imports: [NzTableModule, NzButtonModule, NzPopconfirmModule, RouterModule],
  templateUrl: './link-list.html',
  styleUrl: './link-list.css',
})
export class LinkList implements OnInit{

  links: Link[] = [];

  constructor(
    private service: LinkService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadLinks();
  }

  loadLinks() {
    this.service.getAll().subscribe((page:any) => {
      this.links = page.content;
    });
  }

  edit(id: number) {
    this.router.navigate(['/edit', id]);
  }

  delete(id:number) {
    this.service.delete(id).subscribe(() => {
      this.loadLinks();
    });
  }
}
