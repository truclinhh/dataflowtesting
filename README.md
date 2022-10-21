# BÁO CÁO KIỂM THỬ LUỒNG DỮ LIỆU

## Xây dựng đồ thị luồng điều khiển DFG

![markdown](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/caf438a5-cce1-4252-84ed-58974d103ca4/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221021%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221021T153408Z&X-Amz-Expires=86400&X-Amz-Signature=0ff0e9490ac95abf096c2310c965749780372fa6699ab52f02a4fc69ecf3f682&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject)

## Xác định def, c-use, p-use

- Biến midTermScore:
    - def(midTermScore) = {1}
    - c-use(midTermScore) = {}
    - p-use(midTermScore) = {2,3,6}
    
- Biến absentLectures:
    - def(absentLectures) = {1}
    - c-use(absentLectures) = {}
    - p-use(absentLectures) = {4,5,6}

## Xác định các đường đi

Do đối với chương trình này không có các câu lệnh c-use nên với mọi câu lệnh def, ta sẽ chọn ít nhất 1 câu lệnh p-use để xác định def-clear path và xây dựng ca kiểm thử.

| ID | Variable | Du-pair | Def-clear path | Complete path |
| --- | --- | --- | --- | --- |
| 1 | midTermScore | 1, 2(T) | 1, 2(T) | 1, 2(T) |
| 2 |  | 1,3(F) | 1, 2(F), 3(F) | 1, 2(F), 3(F), 4(T) |
| 3 | absentLectures | 1,5(T) | 1, 2(F), 3(F), 4(F), 5(T) | 1, 2(F), 3(F), 4(F), 5(T) |
| 4 |  | 1,6(F) | 1, 2(F), 3(F), 4(F), 5(F), 6(F) | 1, 2(F), 3(F), 4(F), 5(F), 6(F) |

## Xây dựng các ca kiểm thử

| ID | midTermScore | absentLectures | Expected Output |
| --- | --- | --- | --- |
| 1 | -3 | 2 | -1 |
| 2 | 9 | -5 | -1 |
| 3 | 8 | 17 | -1 |
| 4 | 9 | 4 | 0 |

## Chạy các ca kiểm thử


| ID | midTermScore | absentLectures | Expected Output | System Output | Result |
| --- | --- | --- | --- | --- | --- |
| 1 | -3 | 2 | -1 | -1 | pass |
| 2 | 9 | -5 | -1 | -1 | pass |
| 3 | 8 | 17 | -1 | -1 | pass |
| 4 | 9 | 4 | 0 | 0 | pass |
