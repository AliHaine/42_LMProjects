/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   philo_bonus.h                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ayagmur <marvin@42.fr>                     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2023/02/18 15:52:42 by ayagmur           #+#    #+#             */
/*   Updated: 2023/02/18 15:52:46 by ayagmur          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#ifndef PHILO_BONUS_H
# define PHILO_BONUS_H

# include <unistd.h>
# include <stdlib.h>
# include <stdio.h>
# include <stdbool.h>
# include <pthread.h>
# include <sys/time.h>
# include <semaphore.h>
# include <fcntl.h>

typedef struct s_rules
{
	int				time_to_die;
	int				time_to_eat;
	int				time_to_sleep;
	int				nbr_philo;
	int				nbr_to_eat;
	long long		ms;
	sem_t			*fork;
	sem_t			*msg;
}					t_rules;

typedef struct s_philo
{
	pthread_t		thread;
	int				id;
	int				eated;
	long long		last_eat;
	struct s_rules	*rules;
}					t_philo;

int			ft_atoi(char *arg);
void		p_s(int ms, int id, char *str, sem_t *sem);
int			get_fork(t_philo *philo);
bool		is_death(long long i, int max);
void		ft_sleep(int t);
long long	c_t(void);
void		set_fork(t_philo *philo);
char		*ft_itoa(int i);
void		free_and_exit(struct s_philo *philo);
bool		check_error(struct s_rules rules);
void		ps_helper(char *str);
void		eat_checker(struct s_philo *philo, struct s_rules rules);

#endif
