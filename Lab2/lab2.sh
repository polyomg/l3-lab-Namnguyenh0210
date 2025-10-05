#!/bin/zsh
# Script tự động kill port 8080 và chạy ứng dụng Spring Boot Lab2
# Giải thích: Kill process chiếm port 8080, sau đó khởi động Lab2 và mở web

PORT=8080
PID=$(lsof -ti tcp:$PORT)
if [ -n "$PID" ]; then
  echo "Đang kill tiến trình chiếm port $PORT: PID $PID"
  kill -9 $PID
else
  echo "Port $PORT đang rảnh, không cần kill."
fi

# Chạy ứng dụng Spring Boot Lab2 ở chế độ nền
echo "Đang khởi động ứng dụng Lab2..."
./mvnw spring-boot:run &
SPRING_PID=$!

# Đợi ứng dụng khởi động
sleep 10

# Mở trình duyệt web tới trang chủ Lab2
open http://localhost:8080

# Hiển thị thông báo
echo "Đã mở Lab2 tại http://localhost:8080. Các bài thực hành:"
echo "- Bài 1: OK Controller (/ok)"
echo "- Bài 2: Param Controller (/param/form)"
echo "- Bài 3: Product Form (/product/form)"
echo "- Bài 4: Model Attribute (/product2/form)"
echo "- Bài 5: Result Controller (/a, /b, /c, /d)"
