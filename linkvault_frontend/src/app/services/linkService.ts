import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Link {
  id: number;
  link: string;
  description: string;
}

export interface LinkRequest {
  link: string;
  description: string;
}

export interface Page<T> {
  content: T[];
  page: {
    size: number;
    number: number;
    totalElements: number;
    totalPages: number;
  };

}

@Injectable({
  providedIn: 'root',
})
export class LinkService {
  private readonly API = 'http://172.19.0.6:8080/link';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Page<Link>> {
    return this.http.get<Page<Link>>(this.API);
  }

  save(dto: LinkRequest): Observable<void> {
    return this.http.post<void>(`${this.API}/save`, dto);
  }

  update(id:number, dto:LinkRequest): Observable<Link> {
    return this.http.put<Link>(`${this.API}/${id}`, dto);
  }

  delete(id:number): Observable<void> {
    return this.http.delete<void>(`${this.API}/delete/${id}`)
  }
 }
