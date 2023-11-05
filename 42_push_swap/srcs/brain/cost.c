/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   cost.c                                             :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ayagmur <marvin@42.fr>                     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2023/01/21 15:42:51 by ayagmur           #+#    #+#             */
/*   Updated: 2023/01/27 16:30:31 by ayagmur          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include "../../push_swap.h"

static int	get_minv_val(int *cost)
{
	int	i;
	int	minval;

	i = 0;
	minval = cost[i];
	while (cost[i])
	{
		if (cost[i] < minval && cost[i] != 0)
			minval = cost[i];
		i++;
	}
	i = 0;
	while (cost[i] != minval)
		i++;
	free(cost);
	return (i + 1);
}

int	get_total_cost(t_core *core)
{
	int		ca;
	int		cb;
	int		*cost;
	int		i;
	t_cont	*iterator;

	cost = malloc((sizeof(int)) * (core->p2->size + 1));
	if (!cost)
		return (0);
	cost[core->p2->size] = 0;
	if (cost == NULL)
		return (0);
	iterator = core->p2->first;
	i = 0;
	while (iterator)
	{
		ca = costa(iterator, core->p1);
		cb = costb(iterator->index, core->p2);
		cost[i] = ca + cb;
		iterator = iterator->next;
		i++;
	}
	return (get_minv_val(cost));
}
