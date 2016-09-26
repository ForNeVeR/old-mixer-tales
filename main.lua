-- $Name:Сказки старого Миксера$
-- $Version:0.0.1$

instead_version "2.4.1"

if stead.version < "1.5.3" then
	walk = _G["goto"]
	walkin = goin
	walkout = goout
	walkback = goback
end

require "xact"
require "hideinv"
require "quotes"

game.codepage="UTF-8";

game.act = "Не получается.";
game.inv = "Гм… Странная штука…";
game.use = "Не сработает.";

main = room {
    forcedsc = true,
    nam = "У костра",
    dsc = [[
    Ночь. Прохладный ветерок обдувает сидящих вокруг костра детей и взрослых.
    Сгорбившийся старец с зелёной кожей заканчивает свой рассказ, но никто не
    расходится — не так часто дядюшка Миксер выбирается к костру, чтобы
    рассказать односельчанам историй из своей долгой, насыщенной приключениями
    жизни.^^

    {next|Подойти к костру поближе}.
    ]],
    obj = {
        xact("next", code[[walk(choosing_the_story);]]),
    }
};

choosing_the_story = dlg {
    nam = "Выбор сказки",
    dsc = [[
    Кто-то из детей выкрикивает: «Дядя Миксер, расскажите, пожалуйста, про
    капитана Хорту!»
    ]],
    obj = {
        -- We want to keep the first choice active so that the player can choose it repeatedly and see Mixer grunt about it :)
        [1] = phr("Поддержать предложение.", true, [[pon(1,3); walk(story_captain_horta);]]),
        [2] = phr("Попросить сказку о Славном Форневере.", true, [[pon(3); walk(story_glorious_fornever);]]),
        [3] = _phr("Пойти спать.", true, [[walk(finale);]]),
    }
};

story_captain_horta = room {
    var {
        told = false,
    },
    nam = "Сказка о капитане Хорте",
    dsc = function(s)
        p [[
        Старец Миксер на секунду задумывается, а затем произносит рассерженным
        голосом:^^
        ]];
        if s.told then
            p [[
            — Эту сказку я сегодня уже рассказывал!^^
            ]];
        else
            p [[
            — И слова о нём не расскажу! Полжизни на службе у этого чёрта
            угробил!^^
            ]];
            s.told = true;
        end;
        p [[
        {next|Далее}.
        ]];
    end,
    obj = {
        xact("next", code[[walk(choosing_the_story);]]),
    },
};

story_glorious_fornever = room {
    nam = "Сказка о Славном Форневере",
    dsc = [[
    Старец Миксер нахмурился. Помолчав с минуту, он наконец ответил:^^

    — Форневер? Какой Форневер?^^

    У Миксера такое бывает: он то забывает, то вспоминает истории о своём
    давнишнем товарище Форневере. Ну, ничего, можно ведь {next|попросить другую
    историю}.
    ]],
    obj = {
        xact("next", code[[walk(choosing_the_story);]]),
    },
};

finale = room {
    nam = "Пора отдыхать",
    dsc = [[
    Вдоволь наслушавшись сказок старого Миксера, вы уходите спать.
    ]],
};
