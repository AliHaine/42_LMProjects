/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   push_swap_bonus.h                                  :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ayagmur <marvin@42.fr>                     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2023/01/25 18:20:36 by ayagmur           #+#    #+#             */
/*   Updated: 2023/01/25 18:20:38 by ayagmur          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#ifndef PUSH_SWAP_PUSH_SWAP_BONUS_H
# define PUSH_SWAP_PUSH_SWAP_BONUS_H

#include "get_next_line/get_next_line.h"
#include "push_swap.h"

int		load_main_bonus(char **argv, struct s_core *core, int i);
int		load_main_splitter_bonus(char *argv, struct s_core *core, int i);
void	set_nn_bonus(struct s_pile *p1, int size, int i, int low);
bool	is_sort_bonus(t_pile *p1);

#endif
