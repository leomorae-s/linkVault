import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { enviroment } from '../../enviroment/enviroment';

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
  totalElements: number;
  totalPages: number;
  size: number;
  number: number;
  numberOfElements: number;
  empty: boolean;
  first: boolean;
  last: boolean;
  pageable: {
    offset: number;
    pageNumber: number;
    pageSize: number;
    paged: boolean;
  };
}

@Injectable({
  providedIn: 'root',
})
export class LinkService {
  private readonly API = enviroment.apiUrl;

  constructor(private http: HttpClient) { }


  getAll(): Observable<any> {
    return this.http.get<any>(this.API);

  }

  save(dto: LinkRequest): Observable<void> {
    return this.http.post<void>(`${this.API}/save`, dto);
  }

  update(id: number, dto: LinkRequest): Observable<Link> {
    return this.http.put<Link>(`${this.API}/${id}`, dto);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.API}/delete/${id}`)
  }
}
