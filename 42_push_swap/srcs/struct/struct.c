/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   struct.c                                           :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ayagmur <marvin@42.fr>                     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2023/01/21 15:43:51 by ayagmur           #+#    #+#             */
/*   Updated: 2023/01/21 15:43:52 by ayagmur          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include "../../push_swap.h"

void	reverse_rotate_elem(short mode, t_core *core, bool write)
{
	t_pile	*target;

	target = core->p2;
	if (mode == 1)
	{
		action_writter("rra", write);
		target = core->p1;
	}
	else
		action_writter("rrb", write);
	update_index(target, 1);
	target->first->prev = target->last;
	target->last = target->last->prev;
	target->first->prev->next = target->first;
	target->first = target->first->prev;
	target->first->prev = NULL;
	target->last->next = NULL;
	target->first->index = 1;
	if (mode == 3)
	{
		reverse_rotate_elem(1, core, write);
		action_writter("rrr", write);
	}
}

void	rotate_elem(short mode, t_core *core, bool write)
{
	t_pile	*target;

	target = core->p2;
	if (mode == 1)
	{
		action_writter("ra", write);
		target = core->p1;
	}
	else
		action_writter("rb", write);
	update_index(target, -1);
	target->last->next = target->first;
	target->first = target->first->next;
	target->last->next->prev = target->last;
	target->last = target->last->next;
	target->last->next = NULL;
	target->first->prev = NULL;
	target->last->index = target->last->prev->index + 1;
	if (mode == 3)
	{
		action_writter("rr", write);
		rotate_elem(1, core, write);
	}
}

void	push_elem(short mode, t_core *core, bool write)
{
	t_pile	*r;
	t_pile	*g;

	if (mode == 2)
	{
		r = core->p1;
		g = core->p2;
		action_writter("pa", write);
		push_elem_pa(r, g);
	}
	else
	{
		r = core->p2;
		g = core->p1;
		action_writter("pb", write);
		push_elem_pb(r, g);
	}
}

void	swap_elem(short mode, t_core *core, bool write)
{
	t_cont	*tmp;
	t_pile	*target;

	target = core->p2;
	if (mode == 1)
	{
		action_writter("sa", write);
		target = core->p1;
	}
	else
		action_writter("sb", write);
	tmp = target->first->next;
	target->first->next = tmp->next;
	target->first->prev = tmp;
	tmp->next = target->first;
	tmp->prev = NULL;
	target->first = tmp;
	target->first->next->next->prev = target->first->next;
	target->first->index = 1;
	target->first->next->index = 2;
	if (mode == 3)
	{
		swap_elem(2, core, write);
		action_writter("ss", write);
	}
}

bool	create_new_cont(int n, struct s_pile *p)
{
	t_cont	*cont;

	cont = malloc(sizeof(*cont));
	if (cont == NULL)
		return (false);
	cont->next = NULL;
	cont->prev = NULL;
	if (p->first == NULL)
		p->first = cont;
	else
	{
		p->last->next = cont;
		cont->prev = p->last;
	}
	p->last = cont;
	cont->val = n;
	cont->index = p->size + 1;
	cont->nn = 0;
	p->size++;
	return (true);
}
