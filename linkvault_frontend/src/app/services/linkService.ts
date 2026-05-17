import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
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
  private readonly HEADERS = new HttpHeaders({"API-VERSION": "1.0"})
  private readonly OPTIONS = {headers: this.HEADERS}

  constructor(private http: HttpClient) { }


  getAll(): Observable<any> {
    return this.http.get<any>(this.API, this.OPTIONS);

  }

  save(dto: LinkRequest): Observable<void> {
    return this.http.post<void>(`${this.API}/save`, dto, this.OPTIONS);
  }

  update(id: number, dto: LinkRequest): Observable<Link> {
    return this.http.put<Link>(`${this.API}/${id}`, dto, this.OPTIONS);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.API}/delete/${id}`, this.OPTIONS);
  }
}
