import { Routes } from '@angular/router';
import { LinkList } from './pages/link-list/link-list';
import { LinkForm } from './pages/link-form/link-form';

export const routes: Routes = [
    { path: '', component: LinkList},
    { path: 'new', component: LinkForm},
    { path: 'edit/:id', component: LinkForm}
];
