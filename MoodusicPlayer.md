#2010190719 오인영

사용자의 기분에 따라 가수와 앨범을 추천해주고 음악을 재생해준다.

# Introduction #

이 프로그램의 이름은 'Moodusic Player'이고 Java로 쓰여졌다. 사용자의 기분과 여러가지 상황에 따라 가수와 앨범을 추천해주고 사용자가 추천된 음악 중 선택을 하면 음악을 자동으로 이어서 재생해준다.

# Background #

평소에 음악을 좋아하는 나는 자바 텀프로젝트로 어떤 프로그램을 만들지 생각하다가 나의 기분에 따라서 음악을 추천해주는 프로그램이 있으면 좋겠다고 생각했다.

# Details #

사용자가 성별과 나이를 입력하고 여러가지 질문사항에 대해 답을 입력한다. 질문은 사용자의 답을 통해 그의 기분을 분석 할 수 있는 것들을 할 것이다. 사용자의 입력이 끝나면 입력들을 중심으로 그의 기분을 분석하여 어떤 기분인지 나타내주고 그 기분에 들으면 좋을 가수들과 앨범 또는 노래를 추천해준다. 그리고 사용자가 그 중에서 듣고 싶은 음악을 선택하면 그 노래를 재생해주거나 또는 랜덤으로 추천목록의 노래를 재생할 수 있다. 노래와 함께 앨범 아트와 가사도 제공된다. 추후 상황에 따라 수정될 가능성이 있다.

# Using the Code #

javax.sound.midi 패키지를 불러와서 sequencer를 이용해서 구현한다.
버튼을 누를 수 있게 그래픽적 요소를 가미한다.

pubilc class PlayLauncher { public static void main (String[.md](.md) args)

> }
}
public class a extends a\_Frame {

> Label1, Label2, …
> Panel1, Panel2, …

}

public class Player {

> play()
> stop()
> randomplay()

}