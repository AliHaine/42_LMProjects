/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   push_swap.h                                        :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ayagmur <marvin@42.fr>                     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2023/01/21 16:00:57 by ayagmur           #+#    #+#             */
/*   Updated: 2023/01/21 16:01:01 by ayagmur          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#ifndef PUSH_SWAP_H
# define PUSH_SWAP_H

# include <string.h>
# include <unistd.h>
# include <stdlib.h>
# include <fcntl.h>
# include <stdio.h>
# include <stdbool.h>

# define ERROR_ALR_NBR "Ce nombre est déjà défini"
# define ERROR_NOT_NBR "Seul les nombres sont acceptes"

typedef struct s_cont
{
	int				val;
	int				index;
	int				nn;
	struct s_cont	*next;
	struct s_cont	*prev;
}					t_cont;

typedef struct s_pile
{
	struct s_cont	*last;
	struct s_cont	*first;
	int				size;
}					t_pile;

typedef struct s_core
{
	struct s_pile	*p1;
	struct s_pile	*p2;
}					t_core;

void				set_nn(struct s_pile *p1, int size, int i, int low);
int					load_main(char **argv, struct s_core *core, int i);
int					load_main_splitter(char *argv, struct s_core *core, int i);
int					sort_base_pile(t_core *core);
bool				is_str_contains(char *src, char *val);
void				action_writter(char *ac, bool writer);
void				error_manager(char *msg, t_core *core);
long long int		ft_atoi(char *s);
bool				is_digit(char c);
bool				is_number(char *s);
long long int		get_number(char *s);
bool				is_sort(t_pile *p1);
void				set_nn_helper(t_pile *p1, int *size, t_cont **iterator, int i);
void				sort_helper(t_core *core, t_cont *n2, t_cont *n3);
void				push_elem_pb(t_pile *r, t_pile *g);
void				push_elem_pa(t_pile *r, t_pile *g);
void				write_ss(char *ac);
void				write_rr(char *ac);
void				write_rrr(char *ac);
void				update_index(struct s_pile *p, int i);
void				free_struct(t_core *core);
t_cont				*get_cont_from_index(struct s_pile *p, int index);
void				reverse_rotate_elem(short mode, t_core *core, bool write);
void				rotate_elem(short mode, t_core *core, bool write);
void				push_elem(short mode, t_core *core, bool write);
void				swap_elem(short mode, t_core *core, bool write);
bool				create_new_cont(int n, struct s_pile *p);
bool				is_val_alr(int i, struct s_pile *p);
bool				is_less_nn(int nn, t_pile *p);
bool				is_bigger_nn(int nn, t_pile *p);
bool				sncf_grp(t_core *core);
void				set_to_last(t_core *core);
int					costa(t_cont *cont, t_pile *p1);
int					costb(int index, t_pile *p2);
int					get_total_cost(t_core *core);
void				action_spammer(char *str, int count, t_core *core);
void				brain(t_core *core, int i);
int					brain_short(t_core *core);
void				loader_line(t_core *core);
void				set_toreceive_a(int spam, t_core *core, int place);
void				set_topush_b(int spam, int index, t_core *core);

#endif
