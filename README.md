# Você está na branch main e fez uma alteração
$ echo "console.log('Oi');" >> script.js

# Verifica o status
$ git status
On branch main
Changes not staged for commit:
  modified:   script.js

# Salva temporariamente essa alteração
$ git stash
Saved working directory and index state WIP on main: abc1234 Mensagem do commit

# Agora seu diretório está limpo
$ git status
On branch main
nothing to commit, working tree clean

# Volta com a alteração guardada
$ git stash pop
On branch main
Changes not staged for commit:
  modified:   script.js
Dropped refs/stash@{0} (WIP on main: abc1234 Mensagem do commit)
