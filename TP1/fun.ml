


let rec fact : int -> int =
        fun n ->
                if (n=0 || n=1) then 1
                else ((fact (n-1)) *n)
;;

let n=fact 12 in 
 print_int n;;
