/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   brain.c                                            :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ayagmur <marvin@42.fr>                     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2023/01/21 15:42:32 by ayagmur           #+#    #+#             */
/*   Updated: 2023/01/21 15:42:34 by ayagmur          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include "../../push_swap.h"

static int	find_place_tolowes(t_pile *p)
{
	int		minv;
	t_cont	*iterator;

	iterator = p->first;
	minv = iterator->nn;
	while (iterator)
	{
		if (minv > iterator->nn)
			minv = iterator->nn;
		iterator = iterator->next;
	}
	iterator = p->first;
	while (iterator)
	{
		if (iterator->nn == minv)
			return ((iterator->index));
		iterator = iterator->next;
	}
	return (0);
}

static int	find_place_tobigger(t_pile *p)
{
	int		max;
	t_cont	*iterator;

	iterator = p->first;
	max = iterator->nn;
	while (iterator)
	{
		if (max < iterator->nn)
			max = iterator->nn;
		iterator = iterator->next;
	}
	iterator = p->first;
	while (iterator)
	{
		if (iterator->nn == max)
			return (iterator->index);
		iterator = iterator->next;
	}
	return (0);
}

static int	find_place(t_pile *p, int nn)
{
	t_cont	*iterator;

	if (is_less_nn(nn, p))
		return (find_place_tolowes(p));
	if (is_bigger_nn(nn, p))
	{
		return (find_place_tobigger(p));
	}
	if (nn < p->first->nn && nn > p->last->nn)
		return (0);
	iterator = p->first->next;
	while (iterator)
	{
		if (nn < iterator->nn && nn > iterator->prev->nn)
			return (iterator->index);
		iterator = iterator->next;
	}
	return (0);
}

static void	brain_cation(int saveca, t_cont *cont, t_core *core, int place)
{
	if (saveca % 2 > 0 && !is_bigger_nn(cont->nn, core->p1))
		set_toreceive_a(saveca / 2 + 1, core, place);
	else
		set_toreceive_a(saveca / 2, core, place);
}

void	brain(t_core *core, int i)
{
	t_cont		*cont;
	int			saveca;
	int			place;

	while (core->p2->size > 0)
	{
		cont = get_cont_from_index(core->p2, get_total_cost(core));
		set_topush_b(costb(cont->index, core->p2) - 1, cont->index, core);
		saveca = costa(cont, core->p1);
		place = find_place(core->p1, core->p2->first->nn);
		if (saveca == 1)
			set_to_last(core);
		else
		{
			if (saveca > 0)
				brain_cation(saveca, cont, core, place);
			push_elem(2, core, true);
			while (sncf_grp(core) == true)
			{
				push_elem(2, core, true);
				i++;
			}
			i = 0;
		}
	}
}
