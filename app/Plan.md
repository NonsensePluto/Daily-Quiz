# План работы
---
## День 1:
**Точно:**  
-Подключение зависимостей,  
-Инициализация гита,  
-Организация работы с сетью,  
-Создание главного экрана.

**Неточно:**  
-Создание второго экрана с вопросами
---
## День 2:
**Точно:**  
-Создание второго экрана с вопросами,  
-Навигация,
-Создание финального экрана,  
-Организация сохранения истории, сохранять нужно и дату и время, скорее всего Room  
-Создание экрана историй, и вывод всех записей, организация контекстного меню при удерживании записи!!!

**Неточно:**  
-Подгон дизайна, создание красивого вывода ответа как в фигме
---
## День 3:
-Доделать все что не успел за два дня,  
-Разобраться с текстом получаемых ответов(Парсить их чтобы не было символов неизвестных, может перевод сделать как то если возможно)
-Багофикс,  
-Подгон дизайна,  
-Выполнение задания с усложнением, хотя бы часть.
---
## Технологии
**Что подключить**  
Hilt, Retrofit, OkHttp, Room(мб SharedPreferences), Navigation, javapoet(мб).

---
## Заметки: 
Мне не пригодится коил  
Экран с вопросами это не экран, а просто продолжение первого экрана  
Посмотреть текст в AnswerOption  
Добавить обработку отсутствия интернета  
Добавить надпись внизу экрана QuizCard о том что нельзя вернуться, и стрелочку назад зачем то  
Немножко переработал экран ответов полученных результатов, отклонился от дизайна, но мне кажется так выглядит лучше  
Внизу экрана результатов, повторяетс кнопка начать заново  
Из-за того что использую один вью модел на все приложение пришлось объявлять его в навигации, и она теперь выглядит необычно  

---
### Сделано день 1:
Созал репозиторий, подключил зависимости  
На вечер: сделал все поставленные обязательные задачи, после отдыха продолжу сегодня делать необязательные задачи  
Частично сделал необязательные цели  

### Сделвно день 2:
Доделал весь квиз, его логику и внешний вид
Частично сделал экран результатов
Сделлал весь экран результатов
Подключил бд и все для работы с бд
Добавил всю логику для работы с бд
Организовал навигацию
На завтра остается реализация экрана истории и доп задания  

Нейронка:
-Наткнулся на гите на реализацию работы с сетью, проанализировал ее и решил что это может быть хорошей практикой,  
попросил нейронку оптимизировать это решение под мой проект, реализовала safeCall, пока не добавлял в проект так как еще не разобрался с этим
уверен что разберусь, понравилась идея обертки для результата операции
-Помогла подобрать подходящий шрифт на главный экран
-Организавал генератор для вариантов ответа
промт(твоя задача организовать генератор для выбора ответа AnswerOption,
должно быть 4 варианта ответа, они должны высвечиваться сразу после текста вопроса, а сразу за ними кнопка "Далее" которую мы с тобой обсуждали вчера,
но самое главное это эти 4 вопроса, они не должны быть просто 4мя полями, я хочу чтобы у них был генератор,
который выводит столько опций сколько есть вариантов в списке shuffledAnswers, в общем реализуй такой генератор)
-Реализовал карточки ответов в окне результатов, потому что я устал их делать
(промт: -Реализуй карточку показаную на фото, за основу возьми QwizCard, -В этой карточке будут отображаться ответы пользователя и показываться правильные они или нет,
Пока реализуй просто внешний вид)
-Делегировал сгенерить репозиторий к бд и useCase к каждому методу репозитория