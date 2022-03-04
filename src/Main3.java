import java.util.ArrayList;
import java.util.List;

public class Main3 {
    private char[][] _board;
    int[] dx = {0, 0, 1, 0, -1};
    int[] dy = {0, 1, 0, -1, 0};

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        _board = board;
        for (String word : words) {
            if (bfs(0, 0, word, 0)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean bfs(int x, int y, String word, int idx) {
        if (idx == word.length()) {
            return true;
        }

        for (int i = 0; i <= 4; i++) {
            int _x = x + dx[i];
            int _y = y + dy[i];
            if (valid(_x, _y) && _board[_x][_y] == word.charAt(idx)) {
                return bfs(_x, _y, word, idx + 1);
            }
        }
        return false;
    }

    private boolean valid(int x, int y) {
        int row = _board.length;
        int col = _board[0].length;
        return x >= 0 && x < row && y >= 0 && y < col;
    }


}
