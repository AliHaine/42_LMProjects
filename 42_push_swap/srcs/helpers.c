/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   helpers.c                                          :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ayagmur <marvin@42.fr>                     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2023/01/23 10:08:15 by ayagmur           #+#    #+#             */
/*   Updated: 2023/01/23 10:08:20 by ayagmur          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include "../push_swap.h"

static void	push_elem_helper(t_pile *r, t_pile *g, t_cont *tmp)
{
	r->first->prev = NULL;
	g->first = tmp;
	g->first->prev = NULL;
	if (tmp == NULL)
		g->last = NULL;
	r->size++;
	g->size--;
}

void	push_elem_pa(t_pile *r, t_pile *g)
{
	t_cont	*tmp;

	if (g->first == NULL)
		return ;
	if (g->first->next != NULL)
		tmp = g->first->next;
	else
		tmp = g->first;
	if (r->first == NULL)
	{
		r->first = g->first;
		r->first->next = NULL;
		r->last = g->first;
	}
	else
	{
		update_index(r, 1);
		r->first->prev = g->first;
		r->first->prev->next = r->first;
		r->first = r->first->prev;
	}
	push_elem_helper(r, g, tmp);
	update_index(g, -1);
}

void	push_elem_pb(t_pile *r, t_pile *g)
{
	t_cont	*tmp;

	if (g->first == NULL)
		return ;
	if (g->first->next != NULL)
		tmp = g->first->next;
	else
		tmp = g->first;
	if (r->first == NULL)
	{
		r->first = g->first;
		r->first->next = NULL;
		r->last = g->first;
	}
	else
	{
		update_index(r, 1);
		r->first->prev = g->first;
		r->first->prev->next = r->first;
		r->first = r->first->prev;
	}
	push_elem_helper(r, g, tmp);
	update_index(g, -1);
}

void	set_nn_helper(t_pile *p1, int *size, t_cont **iterator, int i)
{
	get_cont_from_index(p1, i)->nn = *size;
	*iterator = p1->first;
	*size = *size + 1;
}

void	sort_helper(t_core *core, t_cont *n2, t_cont *n3)
{
	if (core->p1->first->nn > n2->nn && n2->nn < n3->nn
		&& core->p1->first->nn < n3->nn)
		swap_elem(1, core, true);
	else if (core->p1->first->nn > n2->nn && n2->nn < n3->nn
		&& core->p1->first->nn > n3->nn)
	{
		reverse_rotate_elem(1, core, true);
		reverse_rotate_elem(1, core, true);
	}
	else
		reverse_rotate_elem(1, core, true);
}
