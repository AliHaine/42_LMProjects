/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   load.c                                             :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ayagmur <marvin@42.fr>                     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2023/01/21 15:43:18 by ayagmur           #+#    #+#             */
/*   Updated: 2023/01/21 15:43:19 by ayagmur          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include "../../push_swap.h"

int	sort_base_pile(t_core *core)
{
	t_cont	*n2;
	t_cont	*n3;

	n2 = core->p1->first->next;
	n3 = core->p1->first->next->next;
	if (core->p1->first->nn < n2->nn && n2->nn < n3->nn)
		return (0);
	else if (core->p1->first->nn < n2->nn && n2->nn > n3->nn
		&& core->p1->first->nn < n3->nn)
	{
		reverse_rotate_elem(1, core, true);
		swap_elem(1, core, true);
	}
	else if (core->p1->first->nn > n2->nn && n2->nn > n3->nn)
	{
		rotate_elem(1, core, true);
		swap_elem(1, core, true);
	}
	else
		sort_helper(core, n2, n3);
	return (0);
}

int	load_main(char **argv, struct s_core *core, int i)
{
	long long int	n;

	while (argv[i])
	{
		if (is_number(argv[i]) == false)
			error_manager(ERROR_NOT_NBR, core);
		n = get_number(argv[i]);
		if (n > 2147483647 || n < -2147483648)
			return (0);
		if (is_val_alr(n, core->p1) == true)
			error_manager(ERROR_ALR_NBR, core);
		if (!create_new_cont(n, core->p1))
			return (0);
		i++;
	}
	set_nn(core->p1, 1, 0, 0);
	if (core->p1->size == 3)
		return (sort_base_pile(core));
	if (is_sort(core->p1) == true)
		return (0);
	loader_line(core);
	if (core->p1->size + core->p2->size == 5)
		return (5);
	return (1);
}
