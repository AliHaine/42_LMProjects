/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   cost_utils.c                                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ayagmur <marvin@42.fr>                     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2023/01/21 15:43:03 by ayagmur           #+#    #+#             */
/*   Updated: 2023/01/21 15:43:05 by ayagmur          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include "../../push_swap.h"

static int	get_val(t_cont *iterator, int size)
{
	if (iterator->index >= size / 2)
	{
		if (!iterator->prev)
			return (0);
		if (!iterator->next)
			return (2);
		return (((size - (iterator->prev->index)) * 2) - 1);
	}
	if (!iterator->prev)
		return (0);
	if ((iterator->index) == 3)
		return (4);
	if ((iterator->index) % 2 == 0)
		return (((iterator->index) * 2) - 2);
	return ((iterator->index - 1) * 2);
}

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
			return (get_val(iterator, p->size));
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
		{
			if (iterator->index >= p->size / 2)
				return (((p->size - (iterator->prev->index)) * 2) - 1);
			return ((iterator->index) * 2);
		}
		iterator = iterator->next;
	}
	return (0);
}

int	costb(int index, t_pile *p2)
{
	t_cont	*iterator;

	iterator = p2->first;
	while (iterator)
	{
		if (iterator->index == index)
			break ;
		iterator = iterator->next;
	}
	if (iterator->index >= p2->size / 2)
		return (p2->size - iterator->index + 2);
	return (iterator->index);
}

int	costa(t_cont *cont, t_pile *p1)
{
	t_cont	*iterator;

	if (cont->nn < p1->first->nn && cont->nn > p1->last->nn)
		return (0);
	if (is_bigger_nn(cont->nn, p1))
		return (find_place_tobigger(p1));
	else if (is_less_nn(cont->nn, p1))
		return (find_place_tolowes(p1));
	iterator = p1->first->next;
	while (iterator)
	{
		if (cont->nn < iterator->nn && cont->nn > iterator->prev->nn)
		{
			if (iterator->index >= p1->size / 2)
				return (((p1->size - (iterator->prev->index)) * 2));
			return ((iterator->index - 1) * 2);
		}
		iterator = iterator->next;
	}
	return (0);
}
